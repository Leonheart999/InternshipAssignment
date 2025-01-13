package ge.levanchitiashvili.internshipassignment.services;

import ge.levanchitiashvili.internshipassignment.dtos.TransferDTO;
import ge.levanchitiashvili.internshipassignment.requests.CargoListRequest;

public interface TransferService {

    public TransferDTO calculateCheapestTransferRoute(CargoListRequest cargoListRequest);
}
