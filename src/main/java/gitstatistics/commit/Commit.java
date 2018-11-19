package gitstatistics.commit;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "gs_commit")
public class Commit {

	@Id
	private String id;

	@Column(name = "repository_id")
	private String repoId;

	@Column(name = "short_message")
	private String shortMessage;

	@Column(name = "author_name")
	private String authorName;

	@Column(name = "author_email")
	private String authorEmail;

	@Column(name = "author_when")
	private Date authorWhen;

	private Integer insertion;

	private Integer deletion;

	private boolean ignored;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRepoId() {
		return repoId;
	}

	public void setRepoId(String repoId) {
		this.repoId = repoId;
	}

	public String getShortMessage() {
		return shortMessage;
	}

	public void setShortMessage(String shortMessage) {
		if (shortMessage == null || shortMessage.length() <= 255) {
			this.shortMessage = shortMessage;
		} else {
			this.shortMessage = shortMessage.substring(0, 255);
		}
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getAuthorEmail() {
		return authorEmail;
	}

	public void setAuthorEmail(String authorEmail) {
		this.authorEmail = authorEmail;
	}

	public Date getAuthorWhen() {
		return authorWhen;
	}

	public void setAuthorWhen(Date authorWhen) {
		this.authorWhen = authorWhen;
	}

	public Integer getInsertion() {
		return insertion;
	}

	public void setInsertion(Integer insertion) {
		this.insertion = insertion;
	}

	public Integer getDeletion() {
		return deletion;
	}

	public void setDeletion(Integer deletion) {
		this.deletion = deletion;
	}

	public boolean isIgnored() {
		return ignored;
	}

	public void setIgnored(boolean ignored) {
		this.ignored = ignored;
	}

}
