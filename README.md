# AprilLabsPractice
AprilLabs Practice 
The goal is to implement following functions
* Create a listing with the following properties
  - address
  - beds (optional)
  - baths (optional)
  - price (optional)
  - createdAt (ISO 8601 date time. E.g. 2021-05-05T14:37:27Z)
* Get a list of all the listings in JSON format (you can decide whether to use pagination or not)
* Get the details of a specific listing in JSON format
* Delete a listing
* Get discount rate for a user (UserService class already contains the logic but it is highly recommended to refactor it)


## User and Listing Controller

```java
@RestController
@RequestMapping(path="/users")
public class UserController {

    private final ai.aprillabs.listingapp.service.UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        userService.createUser(user);
        return new ResponseEntity<>(
                user,
                HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public Integer getDiscountRate(@Valid @PathVariable Integer id) {
        return userService.getDiscountRateForUser(id);
    }
}
```


```java
@RestController
@RequestMapping(path="/listings")
public class ListingController {

    private final ListingService listingService;

    @Autowired
    public ListingController(ListingService listingService) {
        this.listingService = listingService;
    }

    @PostMapping
    public ResponseEntity<Listing> createListing(@Valid @RequestBody CreateListingRequestDto listingDto) {
        // TODO: Complete this
        Listing createdListing = listingDto.getListing();
        listingService.createListing(createdListing);
        return new ResponseEntity<>(
                createdListing,
                HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Listing> getListing(@Valid @PathVariable Integer id) {
        return listingService.getListing(id)
                .map(listing -> new ResponseEntity<>(
                        listing,
                        HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // get all listings
    @GetMapping("/getAll")
    public Iterable<Listing> getAllListing(){
        return listingService.getAllListings();
    }

    // delete a listing by ID
    @GetMapping("/delete/{id}")
    public void deleteListing(@Valid @PathVariable Integer id){
        listingService.deleteListing(id);
    }
}
```
## Create a listing 

```java
public class CreateListingRequestDto {
    private Integer id;
    private String address;
    private Integer beds;
    private Integer baths;
    private BigDecimal price;

    public CreateListingRequestDto() {
    }

    public CreateListingRequestDto(Integer id, String address, Integer beds, Integer baths, BigDecimal price) {
        this.id = id;
        this.address = address;
        this.beds = beds;
        this.baths = baths;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getBeds() {
        return beds;
    }

    public void setBeds(Integer beds) {
        this.beds = beds;
    }

    public Integer getBaths() {
        return baths;
    }

    public void setBaths(Integer baths) {
        this.baths = baths;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Listing getListing() {
        return new Listing(id, address, beds, baths, price);
    }
}
```
## What is Next
It is may   not be the prefect and final version if I have more time, I will continue to work on it to perfect my features

