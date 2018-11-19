package gitstatistics.commit;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.diff.DiffEntry;
import org.eclipse.jgit.diff.DiffFormatter;
import org.eclipse.jgit.diff.Edit;
import org.eclipse.jgit.diff.EditList;
import org.eclipse.jgit.lib.PersonIdent;
import org.eclipse.jgit.revwalk.RevCommit;
import org.springframework.stereotype.Service;

import gitstatistics.repo.Repo;

@Service
public class CommitService {

	@Resource
	private CommitRepository commitRepository;

	public void extractFromRepo(Repo repo) throws Exception {
		Git git = Git.open(new File(repo.getDirectory()));
		DiffFormatter diffFormatter = new DiffFormatter(System.out);
		diffFormatter.setRepository(git.getRepository());
		diffFormatter.setDetectRenames(true);
		try {
			Iterable<RevCommit> revCommits = git.log().call();
			for (RevCommit revCommit : revCommits) {
				if (commitRepository.existsById(revCommit.getName())) {
					continue;
				}
				RevCommit[] parents = revCommit.getParents();
				if (parents.length > 1) {
					continue;
				}
				int deletion = 0;
				int insertion = 0;
				List<DiffEntry> diffEntryList = diffFormatter.scan(parents.length == 1 ? parents[0] : null, revCommit);
				for (DiffEntry diffEntry : diffEntryList) {
					EditList editList = diffFormatter.toFileHeader(diffEntry).toEditList();
					for (Edit edit : editList) {
						deletion = deletion + edit.getLengthA();
						insertion = insertion + edit.getLengthB();
					}
				}
				Commit commit = new Commit();
				commit.setId(revCommit.getName());
				commit.setRepoId(repo.getId());
				commit.setShortMessage(revCommit.getShortMessage());
				PersonIdent authorIdent = revCommit.getAuthorIdent();
				commit.setAuthorName(authorIdent.getName());
				commit.setAuthorEmail(authorIdent.getEmailAddress());
				commit.setAuthorWhen(authorIdent.getWhen());
				commit.setInsertion(insertion);
				commit.setDeletion(deletion);
				commitRepository.save(commit);
			}
		}finally {
			diffFormatter.close();
			git.close();
		}
	}

}
