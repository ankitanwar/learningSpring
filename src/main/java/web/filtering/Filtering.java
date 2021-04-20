package web.filtering;


import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//below is the example of the dynamic filtering though if we want to use the static filtering we can make use of the property @JSonIgnore


/*
    DOUBTS :-
    1) http://host:8080/user?id=1;
    and if id is not there just throw an error then we might need to define lots of errors
    or may be database is not working
    or may be ping is not working   -> then there will be lots of exceptions that we might need to handle

    2) how to create something like before making first request execute this something like create table if not exists


    3) which not is better to use dto (data transfer object) or mapping to send and receive the response

    //-> pu
    4 try connect to the database
    5 writing unit test

 */

@RestController
public class Filtering {

    @GetMapping("/filtering")
    public MappingJacksonValue retrieveSomeBean(){
        SomeBean someBean=new SomeBean("value1","value2","value3");
        SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("value2","value3");


        //at somebeanfilter we could have given any name we like but we have to mention it on the class SomeBean
        FilterProvider filters=new SimpleFilterProvider().addFilter("SomeBeanFilter",filter);

        MappingJacksonValue mapping=new MappingJacksonValue(someBean);
        mapping.setFilters(filters);
        return  mapping;

    }
}
