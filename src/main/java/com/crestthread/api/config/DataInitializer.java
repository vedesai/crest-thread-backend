// AI Generated Code by Deloitte + Cursor (BEGIN)
package com.crestthread.api.config;

import com.crestthread.api.model.Category;
import com.crestthread.api.model.Product;
import com.crestthread.api.repository.CategoryRepository;
import com.crestthread.api.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataInitializer implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    @Override
    public void run(String... args) {
        if (categoryRepository.count() == 0) {
            log.info("Initializing sample data...");
            initializeCategories();
            initializeProducts();
            log.info("Sample data initialization complete");
        }
    }

    private void initializeCategories() {
        List<Category> categories = Arrays.asList(
            Category.builder().name("Women").slug("women").description("Women's fashion and apparel").imageUrl("https://images.unsplash.com/photo-1487412720507-e7ab37603c6f?w=400&h=400&fit=crop").displayOrder(1).active(true).build(),
            Category.builder().name("Men").slug("men").description("Men's fashion and apparel").imageUrl("https://images.unsplash.com/photo-1507003211169-0a1dd7228f2d?w=400&h=400&fit=crop").displayOrder(2).active(true).build(),
            Category.builder().name("Kids").slug("kids").description("Kids' fashion and apparel").imageUrl("https://images.unsplash.com/photo-1503454537195-1dcabb73ffb9?w=400&h=400&fit=crop").displayOrder(3).active(true).build(),
            Category.builder().name("Sportswear").slug("sportswear").description("Athletic and sportswear").imageUrl("https://images.unsplash.com/photo-1571019613454-1cb2f99b2d8b?w=400&h=400&fit=crop").displayOrder(4).active(true).build(),
            Category.builder().name("Accessories").slug("accessories").description("Fashion accessories").imageUrl("https://images.unsplash.com/photo-1523170335258-f5ed11844a49?w=400&h=400&fit=crop").displayOrder(5).active(true).build()
        );
        categoryRepository.saveAll(categories);
        log.info("Created {} categories", categories.size());
    }

    private void initializeProducts() {
        Category men = categoryRepository.findBySlug("men").orElseThrow();
        Category women = categoryRepository.findBySlug("women").orElseThrow();
        Category kids = categoryRepository.findBySlug("kids").orElseThrow();

        List<Product> products = Arrays.asList(
            Product.builder().name("Classic White T-Shirt").description("A timeless classic white t-shirt made from premium cotton.").price(new BigDecimal("29.00")).originalPrice(new BigDecimal("39.00")).imageUrl("https://images.unsplash.com/photo-1521572163474-6864f9cf17ab?w=600&h=800&fit=crop").category(men).rating(new BigDecimal("4.5")).reviewCount(342).inStock(true).featured(true).build(),
            Product.builder().name("Slim Fit Denim Jeans").description("Modern slim fit denim jeans with stretch comfort.").price(new BigDecimal("79.00")).originalPrice(new BigDecimal("99.00")).imageUrl("https://images.unsplash.com/photo-1542272604-787c3835535d?w=600&h=800&fit=crop").category(men).rating(new BigDecimal("4.5")).reviewCount(567).inStock(true).featured(true).build(),
            Product.builder().name("Cozy Knit Sweater").description("Warm and stylish knit sweater for cooler days.").price(new BigDecimal("89.00")).originalPrice(new BigDecimal("119.00")).imageUrl("https://images.unsplash.com/photo-1576566588028-4147f3842f27?w=600&h=800&fit=crop").category(women).rating(new BigDecimal("4.5")).reviewCount(234).inStock(true).featured(true).build(),
            Product.builder().name("Summer Floral Dress").description("Light and breezy floral dress perfect for summer days.").price(new BigDecimal("65.00")).originalPrice(new BigDecimal("85.00")).imageUrl("https://images.unsplash.com/photo-1572804013309-59a88b7e92f1?w=600&h=800&fit=crop").category(women).rating(new BigDecimal("4.7")).reviewCount(189).inStock(true).featured(false).build(),
            Product.builder().name("Kids Cotton Hoodie").description("Comfortable cotton hoodie for kids.").price(new BigDecimal("35.00")).originalPrice(new BigDecimal("45.00")).imageUrl("https://images.unsplash.com/photo-1519238263530-99bdd11df2ea?w=600&h=800&fit=crop").category(kids).rating(new BigDecimal("4.8")).reviewCount(156).inStock(true).featured(false).build(),
            Product.builder().name("Casual Polo Shirt").description("Smart casual polo shirt in premium cotton pique fabric.").price(new BigDecimal("45.00")).originalPrice(new BigDecimal("55.00")).imageUrl("https://images.unsplash.com/photo-1625910513413-5fc4e5e6726b?w=600&h=800&fit=crop").category(men).rating(new BigDecimal("4.4")).reviewCount(298).inStock(true).featured(false).build()
        );
        productRepository.saveAll(products);
        log.info("Created {} products", products.size());
    }
}
// AI Generated Code by Deloitte + Cursor (END)
