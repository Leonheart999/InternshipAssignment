package ge.levanchitiashvili.internshipassignment.services;

import ge.levanchitiashvili.internshipassignment.dtos.TransferDTO;
import ge.levanchitiashvili.internshipassignment.model.Cargo;
import ge.levanchitiashvili.internshipassignment.requests.CargoListRequest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TransferServiceImplTest {

    private final TransferServiceImpl transferService = new TransferServiceImpl();

    @Test
    void testCalculateCheapestTransferRoute() {
        CargoListRequest cargoListRequest = new CargoListRequest();
        cargoListRequest.setMaxWeight(15.0);
        List<Cargo> cargos = Arrays.asList(
                new Cargo(5.0, 10.0),
                new Cargo(10.0, 20.0),
                new Cargo(3.0, 5.0),
                new Cargo(8.0, 15.0)
        );
        cargoListRequest.setAvailableTransfers(cargos);

        TransferDTO result = transferService.calculateCheapestTransferRoute(cargoListRequest);

        assertEquals(30.0, result.getTotalCost());
        assertEquals(15.0, result.getTotalWeight());
        assertEquals(2, result.getSelectedTransfers().size());
        assertEquals(5.0, result.getSelectedTransfers().get(0).getWeight());
        assertEquals(10.0, result.getSelectedTransfers().get(1).getWeight());
    }
}
