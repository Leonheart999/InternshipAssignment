package ge.levanchitiashvili.internshipassignment.requests;

import ch.qos.logback.core.joran.sanity.Pair;
import ge.levanchitiashvili.internshipassignment.model.Cargo;
import lombok.Data;

import java.util.List;

@Data
public class CargoListRequest {
    private Double maxWeight;
    private List<Cargo> availableTransfers;

}
