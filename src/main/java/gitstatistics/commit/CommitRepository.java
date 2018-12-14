package gitstatistics.commit;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CommitRepository extends JpaRepository<Commit, String> {

	@Query(nativeQuery = true, value = "select distinct author_name from gs_commit order by author_name;")
	List<String> findAuthors();

	@Query(value = "select c from Commit c where c.authorWhen>=?1 and c.authorWhen<?2 and c.repoId like %?3 and c.authorName like %?4 order by c.repoId, c.insertion desc")
	List<Commit> findCommits(Date startDate, Date endDate, String repoId, String authorName);

}
