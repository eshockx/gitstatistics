package gitstatistics.commit;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gitstatistics.repo.Repo;
import gitstatistics.repo.RepoService;

@RestController
@RequestMapping("/commit")
public class CommitController {

	@Resource
	private CommitService commitService;

	@Resource
	private RepoService repoService;

	@GetMapping("/extract/all")
	public void extractAll() throws Exception {
		List<Repo> repoList = repoService.findAll();
		for (Repo repo : repoList) {
			commitService.extractFromRepo(repo);
		}
	}

	@GetMapping("/extract/repo/{repoId}")
	public void extractFromRepo(@PathVariable String repoId) throws Exception {
		Repo repo = repoService.getOne(repoId);
		commitService.extractFromRepo(repo);
	}

	@GetMapping("/find/authors")
	public List<String> findAuthors() {
		return commitService.findAuthors();
	}

	@GetMapping("/find/startdate/{startDate}/enddate/{endDate}")
	public List<Commit> findCommits(@PathVariable String startDate, @PathVariable String endDate,
			@RequestParam String repoId, @RequestParam String authorName) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return commitService.findCommits(sdf.parse(startDate), sdf.parse(endDate), repoId, authorName);
	}
}
