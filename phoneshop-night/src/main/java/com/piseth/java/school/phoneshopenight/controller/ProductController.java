import com.piseth.java.school.phoneshopenight.dto.PriceDTO;
import com.piseth.java.school.phoneshopenight.dto.ProductDTO;
import com.piseth.java.school.phoneshopenight.dto.ProductImportDTO;
import com.piseth.java.school.phoneshopenight.entity.Product;
import com.piseth.java.school.phoneshopenight.mapper.ProductMapper;
import com.piseth.java.school.phoneshopenight.service.ProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.Map;

@Tag(name = "Product", description = "Product management APIs")
@RestController
@RequestMapping("products")
@RequiredArgsConstructor
public class ProductController {

	private final ProductService productService;
	private final ProductMapper productMapper;

	@Operation(summary = "Create a new product")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> create(@RequestBody ProductDTO productDTO) {
		Product product = productMapper.toProduct(productDTO);
		product = productService.create(product);
		return ResponseEntity.ok(product);
	}

	@Operation(summary = "Import products")
	@PostMapping("importProduct")
	public ResponseEntity<?> importProduct(@RequestBody @Valid ProductImportDTO importDTO) {
		productService.importProduct(importDTO);
		return ResponseEntity.ok().build();
	}

	@Operation(summary = "Set sale price for a product")
	@PostMapping("{productId}/setSalePrice")
	public ResponseEntity<?> setSalePrice(@PathVariable Long productId, @RequestBody PriceDTO priceDTO) {
		productService.setSalePrice(productId, priceDTO.getPrice());
		return ResponseEntity.ok().build();
	}

	@Operation(summary = "Upload products from Excel")
	@PostMapping("uploadProduct")
	public ResponseEntity<?> uploadProduct(@RequestParam("file") MultipartFile file) {
		Map<Integer, String> errorMap = productService.uploadProduct(file);
		return ResponseEntity.ok(errorMap);
	}
}
