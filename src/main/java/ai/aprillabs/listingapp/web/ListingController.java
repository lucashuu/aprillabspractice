package ai.aprillabs.listingapp.web;

import ai.aprillabs.listingapp.domain.Listing;
import ai.aprillabs.listingapp.service.ListingService;
import ai.aprillabs.listingapp.web.dto.request.CreateListingRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
