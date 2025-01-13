package ge.levanchitiashvili.internshipassignment.requests;

import ch.qos.logback.core.joran.sanity.Pair;
import lombok.Data;

import java.util.List;

@Data
public class CargoRequest {
    private Double maxWeight;
    private List<Pair<Double,Double>> availableTransfers;
}
