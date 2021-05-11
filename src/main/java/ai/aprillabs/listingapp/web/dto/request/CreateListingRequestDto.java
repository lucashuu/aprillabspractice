package ai.aprillabs.listingapp.web.dto.request;

import ai.aprillabs.listingapp.domain.Listing;

import java.math.BigDecimal;

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
