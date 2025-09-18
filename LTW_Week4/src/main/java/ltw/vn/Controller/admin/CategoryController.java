package ltw.vn.Controller.admin;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ltw.vn.Entity.Category;
import ltw.vn.Model.CategoryModel;
import ltw.vn.Service.CategoryService;
import org.springframework.web.servlet.ModelAndView;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("admin/categories")
public class CategoryController {
	@Autowired
	CategoryService categoryService;

	@GetMapping("list")
	public String listcategories(ModelMap model) {
		List<Category> list = categoryService.findAll();
		model.addAttribute("categories", list);
		return "admin/categories/list";
	}

	@GetMapping("add")
	public String Add(ModelMap model) {
		CategoryModel cate = new CategoryModel();
		cate.setIsEdit(false);
		model.addAttribute("category", cate);
		return "admin/categories/addOrEdit";
	}

	@PostMapping("saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model, @Valid @ModelAttribute("category") CategoryModel cate,
			BindingResult result) {
		if (result.hasErrors()) {
			return new ModelAndView("/admin/categories/addOrEdit");
		}
		Category entity = new Category();
		BeanUtils.copyProperties(cate, entity);
		categoryService.save(entity);
		String message = "";
		if (cate.getIsEdit() == true) {
			message = "Category da duoc cap nhap thanh cong";
		} else {
			message = "Category da duoc them thanh cong";
		}
		model.addAttribute("message", message);
		return new ModelAndView("forward:/admin/categories/list", model);
	}

	@GetMapping("edit/{categoryId}")
	public ModelAndView edit(ModelMap model, @PathVariable("categoryId") Long categoryId) {
		Optional<Category> opt = categoryService.findById(categoryId);
		CategoryModel cate = new CategoryModel();
		if (opt.isPresent()) {
			Category entity = opt.get();
			BeanUtils.copyProperties(entity, cate);
			cate.setIsEdit(true);
			model.addAttribute("category", cate);
			return new ModelAndView("admin/categories/addOrEdit", model);

		}
		model.addAttribute("message", "Category khong ton tai");
		return new ModelAndView("forward:/admin/categories", model);

	}

	@GetMapping("delete/{categoryId}")
	public ModelAndView delete(ModelMap model, @PathVariable("categoryId") Long categoryId) {
		categoryService.deleteById(categoryId);
		model.addAttribute("message", "Category đã được xóa thành công");
		return new ModelAndView("redirect:/admin/categories", model);
	}

}
