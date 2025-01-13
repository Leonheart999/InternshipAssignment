package ge.levanchitiashvili.internshipassignment.controllers;

import ge.levanchitiashvili.internshipassignment.dtos.TransferDTO;
import ge.levanchitiashvili.internshipassignment.requests.CargoListRequest;
import ge.levanchitiashvili.internshipassignment.services.TransferService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("transfers")
@RequiredArgsConstructor
public class TransferController {
    private final TransferService transferService;
    @PostMapping
    public TransferDTO post(@RequestBody CargoListRequest cargoListRequest) {
        TransferDTO transferDTO= transferService.calculateCheapestTransferRoute(cargoListRequest);
        return transferDTO;
    }
}
