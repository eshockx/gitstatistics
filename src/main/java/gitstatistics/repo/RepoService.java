package gitstatistics.repo;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service
public class RepoService {

	@Resource
	private RepoRepository repoRepository;

	public List<Repo> findAll() {
		return repoRepository.findAll();
	}

	public Repo getOne(String repoId) {
		return repoRepository.getOne(repoId);
	}

}
