package ltw.vn.Model;

import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryModel {
	private Long categoryId; // ✅ sửa lại chính tả & đồng bộ Entity
	private String categoryCode;
	@NotEmpty
	@Length(min = 5)
	private String categoryName;
	private String images;
	private Boolean status;
	private MultipartFile imageFile;
	private Boolean isEdit = false;
}
