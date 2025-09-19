package ltw.vn.Entity;

import java.io.Serializable;
import java.util.Set;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "categories") 
public class Category implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CategoryId")
	private Long  categoryId;

	@Column(name = "CategoryCode", columnDefinition = "nvarchar(255)")
	private String categorycode;

	@Column(name = "CategoryName", columnDefinition = "nvarchar(255)")
	private String categoryname;

	@Column(name = "Images")
	private String images;

	@Column(name = "Status")
	private Boolean status;

	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Video> videos;
}
