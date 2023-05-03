package com.zephyrus.productservice;

//@SpringBootTest
//@Testcontainers
//@AutoConfigureMockMvc
class ProductServiceApplicationTests {
//  @Container
//  static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:4.4.3");
//  @Autowired
//  private MockMvc mockMvc;
//  @Autowired
//  private ObjectMapper objectMapper;
//  @Autowired
//  private ProductRepository productRepository;
//
//  @DynamicPropertySource
//  static void setProperties(DynamicPropertyRegistry registry) {
//    registry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);
//  }
//
//  @Test
//  void shouldCreateProduct() throws Exception {
//    ProductRequest productRequest = getProductRequest();
//    String productRequestString = objectMapper.writeValueAsString(productRequest);
//
//    mockMvc.perform(MockMvcRequestBuilders.post("/api/product")
//            .contentType(MediaType.APPLICATION_JSON)
//            .content(productRequestString))
//        .andExpect(status().isCreated());
//
//    Assertions.assertEquals(1, productRepository.findAll().size());
//  }
//
//  @Test
//  void shouldGetAllProducts() throws Exception {
//    ProductRequest productRequest = getProductRequest();
//    String productRequestString = objectMapper.writeValueAsString(productRequest);
//
//    mockMvc.perform(MockMvcRequestBuilders.post("/api/product")
//            .contentType(MediaType.APPLICATION_JSON)
//            .content(productRequestString))
//        .andExpect(status().isCreated());
//
//    mockMvc.perform(MockMvcRequestBuilders.get("/api/product")
//            .contentType(MediaType.APPLICATION_JSON))
//        .andExpect(status().isOk());
//  }
//
//  private ProductRequest getProductRequest() {
//    return ProductRequest.builder()
//        .name("iPhone 14  Pro")
//        .description("Phone by Apple.")
//        .price(BigDecimal.valueOf(1200))
//        .build();
//  }
}
