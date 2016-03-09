package fr.treeptik.tp.blog.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@XmlRootElement
public class Article implements Serializable {
	private static final long serialVersionUID = -1383536197723807960L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;
	@Column(length = 90000)
	private String subTitle;
	@Column(length = 90000)
	private String content;
	private Date pubDate;
	private Boolean published;;

	@XmlTransient
	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY)
	private Category category;
	@XmlTransient
	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY)
	private Author author;
	@XmlTransient
	@JsonIgnore
	@OneToMany(mappedBy = "article", fetch = FetchType.LAZY)
	private Set<Comment> comments;

	public Article() {
	}

	public Article(String title, String subTitle, String content, Date pubDate,
			boolean published, Category category, Author author) {
		this.title = title;
		this.subTitle = subTitle;
		this.content = content;
		this.pubDate = pubDate;
		this.published = published;
		this.category = category;
		this.author = author;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getPubDate() {
		return pubDate;
	}

	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}

	public boolean isPublished() {
		return published;
	}

	public void setPublished(boolean published) {
		this.published = published;
	}

	@XmlTransient
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@XmlTransient
	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	@XmlTransient
	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((pubDate == null) ? 0 : pubDate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Article other = (Article) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (id != other.id)
			return false;
		if (pubDate == null) {
			if (other.pubDate != null)
				return false;
		} else if (!pubDate.equals(other.pubDate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		String articleString = "Article [id=" + id + ", title=" + title
		/* + ", subTitle="+ subTitle + ", content=" + content + */
		+ ", pubDate=" + pubDate + ", published=" + published + "]";
		return articleString;
	}
}
