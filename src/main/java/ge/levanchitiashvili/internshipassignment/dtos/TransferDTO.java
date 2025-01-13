package ge.levanchitiashvili.internshipassignment.dtos;

import ge.levanchitiashvili.internshipassignment.model.Cargo;
import lombok.Data;

import java.util.List;

@Data
public class TransferDTO {
    private List<Cargo> selectedTransfers;
    private Double totalCost;
    private Double totalWeight;
}
