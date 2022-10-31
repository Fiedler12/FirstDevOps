package service;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import model.Trial;

import java.util.Arrays;
import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
@Path("gettrials")
public class TrialsService {
    //TODO: replace with real database

    Trial trial = new Trial(1, "Novo Nordisk", "Trial 1", "Copenhagen", "This is a trial");

    //private int id = 0;
    //private String company = "Novo Nordisk";
    //private String trials = "diabetes";
    //private String location = "Hillerød";
    //private String description = "Diabetes is a disease in which your blood glucose, or blood sugar, levels are too high. Glucose comes from the foods you eat. Insulin is a hormone that helps the glucose get into your cells to give them energy. With diabetes, your body either doesn't make enough insulin or can't use its own insulin as well as it should. This causes too much glucose to stay in your blood. You can also have prediabetes. This means that your blood sugar is higher than normal but not high enough to be called diabetes. Having prediabetes puts you at a higher risk of getting type 2 diabetes. Type 1 diabetes used to be called juvenile diabetes or insulin-dependent diabetes. Type 2 diabetes used to be called adult-onset diabetes. But people of all ages and sizes can get type 2 diabetes. Type 2 diabetes is the most common type of diabetes. It used to be called adult-onset diabetes. But more and more children and teens are getting type 2 diabetes. Type 2 diabetes is the most common type of diabetes. It used to be called adult-onset diabetes. But more and more children and teens are getting type 2 diabetes. Type 2 diabetes is the most common type of diabetes. It used to be called adult-onset diabetes. But more and more children and teens are getting type 2 diabetes. Type 2 diabetes is the most common type of diabetes. It used to be called adult-onset diabetes. But more and more children and teens are getting type 2 diabetes. Type 2 diabetes is the most common type of diabetes. It used to be called adult-onset diabetes. But more and more children and teens are getting type 2 diabetes. Type 2 diabetes is the most common type of diabetes. It used to be called adult-onset diabetes. But more and more children and teens are getting type 2 diabetes. Type 2 diabetes is the most common type of diabetes. It used to be called adult-onset diabetes. But more and more children and teens are getting type 2 diabetes. Type 2 diabetes is the most common type of diabetes. It used to be called adult-onset diabetes. But more and more children and teens are getting type 2 diabetes. Type 2 diabetes is the most common type of diabetes. It used to be called adult-onset diabetes. But more and more children and teens are getting type 2 diabetes. Type 2 diabetes is the most";

    //List<String> trials = Arrays.asList("Melman", "Elmer");
//    @GET
//    public List<String> getTrials(){
//        return trials;
//    }




    @GET
    public String getTrials(){
        return trial.toString();

    }

}
