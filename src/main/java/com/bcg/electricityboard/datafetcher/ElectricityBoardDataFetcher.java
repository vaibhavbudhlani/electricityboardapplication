package com.bcg.electricityboard.datafetcher;

import com.bcg.electricityboard.Exception.RecordNotFoundException;
import com.bcg.electricityboard.model.Records;
import com.bcg.electricityboard.model.RecordsInput;
import com.bcg.electricityboard.model.RecordsOutput;
import com.bcg.electricityboard.service.RecordsService;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import reactor.core.publisher.Mono;

import java.util.Date;
import java.util.List;

@DgsComponent
@CrossOrigin(origins = "http://localhost:4200")
public class ElectricityBoardDataFetcher {
    @Autowired
    private RecordsService recordsService;


    @DgsQuery
    public Mono<List<Records>> records(){
         return Mono.fromSupplier(() -> {
             try {
                 return recordsService.getAllRecords();
             } catch (RecordNotFoundException e) {
                 throw new RuntimeException(e);
             }
         });
    }

    @DgsQuery
    public Mono<Records> recordsById(@InputArgument float id, DataFetchingEnvironment dfe){
        return  Mono.fromSupplier(() -> {
            try {
                return recordsService.getRecordById(id);
            } catch (RecordNotFoundException e) {
                throw new RuntimeException(e);
            }
        });

    }

    @DgsQuery
    public Mono<List<Records>> recordsByApplicationDate(String startDate, String endDate){
        return Mono.fromSupplier(() -> {
            try {
                return recordsService.recordsBetweenDateRange(startDate,endDate);
            } catch (RecordNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
    }

    @DgsMutation
    public Mono<RecordsOutput> saveRecord(@InputArgument("recordsInput") RecordsInput recordsInput, DataFetchingEnvironment dfe){
         RecordsOutput output = new RecordsOutput();
          output.setValue(recordsService.saveRecords(recordsInput));
          return Mono.just(output);
    }

    @DgsMutation
    public Mono<RecordsOutput> updateRecord(@InputArgument("recordsInput") RecordsInput recordsInput,DataFetchingEnvironment dfe) throws RecordNotFoundException {
        RecordsInput records = dfe.getSource();
        RecordsOutput output = new RecordsOutput();
        output.setValue(recordsService.updateRecord(recordsInput));
        return Mono.just(output);
    }
}
