package com.vesqum.Resourcemanagment.company.Product;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;
/**
 * Kontroler REST dla produktu.
 * Odpowiada za obsługę żądań HTTP dotyczących operacji na danych produktu.
 */

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private final ProductServer productServer;

    public ProductController(ProductServer productServer) {
        this.productServer = productServer;
    }
    /**
     * Pobiera Listę produktów.
     *
     * @return ResponseEntity z listą produktów lub odpowiedź 404, jeśli lista nie został znaleziona
     */
    @GetMapping
//    @Operation(
//            summary = "Get All Product",
//            description = "Retrieves all products form the database"
//    )
//    @ApiResponse(
//            responseCode = "200", description = "Found the products",
//            content = {
//                    @Content(mediaType = "application/json",
//                    schema = @Schema(implementation = Product.class)
//                    )}
//    )
    public ResponseEntity<List<Product>> getAllProduct() {
        return ResponseEntity.ok(productServer.findAll());
    }
    @PostMapping
//    @Operation(summary = "Create a new product", description = "Added a new product to the list of products")
//    @ApiResponse(
//            responseCode = "201",
//            description = "Added a new product to the database",
//            content = {
//                    @Content(mediaType = "application/json",
//                    schema = @Schema(implementation = Product.class))
//            })
    public ResponseEntity<String> createProduct(@RequestBody Product product) {
        productServer.createProduct(product);
        return new ResponseEntity<>("Product created successfully", HttpStatus.CREATED);
    }
    /**
     * Pobiera produktu o podanym ID.
     *
     * @param productId identyfikator produktu
     * @return ResponseEntity z produktu lub odpowiedź 404, jeśli produkt nie został znaleziony
     */
    @GetMapping("/{productId}")
//    @Operation(summary = "Get Product by Id", description = "Retrieves a Product by Id")
//    @ApiResponse(
//            responseCode = "200",
//            description = "Found the Product",
//            content = {
//                    @Content(mediaType = "application/json", schema = @Schema(implementation = Product.class))
//            }
//    )
    public ResponseEntity<Product> getProductById(@PathVariable Long productId) {
        Optional<Product> product = productServer.getEmployeeById(productId);
        return product.map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    /**
     * Aktualizuje produktu o podanym ID nowymi danymi.
     *
     * @param productId identyfikator produktu do aktualizacji
     * @param productDetails nowe dane produktu
     * @return ResponseEntity z zaktualizowanym produktem lub odpowiedź 404, jeśli pracownik nie został znaleziony
     */
    @PutMapping("/{productId}")
//    @Operation(summary = "Update a product", description = "Retrieves a product by id form database and updates it")
//    @ApiResponse(
//            responseCode = "200",
//            description = "Product updated successfully",
//            content = {
//                    @Content(mediaType = "application/json",
//                            schema = @Schema(implementation = Product.class))
//            })
    public ResponseEntity<Product> updateProduct(@PathVariable Long productId, @RequestBody Product productDetails) {
        Product updateProduct = productServer.updateProduct(productId, productDetails);
        return ResponseEntity.ok(updateProduct);
    }
    /**
     * Usuwa produktu o podanym ID z bazy danych.
     * Metoda nie rzuca wyjątku, nawet jeśli produkt o danym ID nie istnieje,
     * aby zachować idempotentność operacji DELETE.
     *
     * @param productId identyfikator produktu do usunięcia
     * @return zwraca HTTP z kodem statusu 200 OK
     */
    @DeleteMapping("/{productId}")
//    @Operation(summary = "Delete a product", description = "Delete a product from the database")
//    @ApiResponse(
//            responseCode = "204",
//            description = "Product deleted",
//            content = {
//                    @Content(mediaType = "application/json",
//                            schema = @Schema(implementation = Product.class)
//            )}
//    )
    public ResponseEntity<?> deleteProduct(@PathVariable Long productId) {
        productServer.deleteProduct(productId);
        return ResponseEntity.ok().build();
    }
}
