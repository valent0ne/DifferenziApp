package it.univaq.disim.mobile.differenziaquila.web;


import it.univaq.disim.mobile.differenziaquila.business.DifferenziAquilaService;
import it.univaq.disim.mobile.differenziaquila.business.domain.WasteCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wastecategory")
public class WasteCategoryController {


    @Autowired
    private DifferenziAquilaService service;

    @PostMapping("/")
    public Response createWasteCategory(@RequestBody WasteCategory wastecategory){
        service.createWasteCategory(wastecategory);
        return Response.DEFAULT_RESPONSE_OK;
    }

    @PutMapping("/{token}")
    public Response updateWasteCategory(@RequestBody WasteCategory wastecategory, @PathVariable String token) {
        service.updateWasteCategory(token, wastecategory);
        return Response.DEFAULT_RESPONSE_OK;
    }

    @GetMapping("/")
    public Response findAllWasteCategories(){
        List<WasteCategory> wastecategory= service.findAllWasteCategories();
        Response<List<WasteCategory>> response= new Response<>(true, "all waste categories");
        response.setData(wastecategory);
        return response;
    }

    @GetMapping ("/{id}")
    public Response findWasteCategoryById(@PathVariable(value="id") Long id){
        WasteCategory wastecategory= service.findWasteCategoryById(id);
        Response<WasteCategory> response= new Response<>(true, "find waste category by id");
        response.setData(wastecategory);
        return response;
    }

    @DeleteMapping ("/{token}/{id}")
    public Response deleteWasteCategory(@PathVariable(value="token") String token,@PathVariable(value="id") Long id) {
        service.deleteWasteCategory(token, id);
        Response<Object> response = new Response<>(true, "waste category deleted");
        return response;
    }
}
