package gitstatistics.repo;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/repo")
public class RepoController {

	@Resource
	private RepoService repoService;

	@GetMapping("/find/all")
	public List<Repo> findAll() {
		return repoService.findAll();
	}

}
