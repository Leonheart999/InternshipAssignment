package ge.levanchitiashvili.internshipassignment.services;

import ge.levanchitiashvili.internshipassignment.dtos.TransferDTO;
import ge.levanchitiashvili.internshipassignment.model.Cargo;
import ge.levanchitiashvili.internshipassignment.requests.CargoListRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class TransferServiceImpl implements TransferService {
    @Override
    public TransferDTO calculateCheapestTransferRoute(CargoListRequest cargoListRequest) {
        TransferDTO transferDTO = new TransferDTO();
        transferDTO.setTotalCost(0.0);
        transferDTO.setTotalWeight(0.0);
        transferDTO.setSelectedTransfers(new ArrayList<>());
        List<Cargo> cargoList=cargoListRequest.getAvailableTransfers();
        for (int i = 0; i < cargoList.size(); i++) {
            recursiveMethod(new ArrayList<>(),i,cargoList,0.0,0.0,cargoListRequest.getMaxWeight(),transferDTO);
        }
        return transferDTO;
    }

    private void recursiveMethod(List<Cargo> current, int elementAdded, List<Cargo> cargosLeft, Double currentPrice, Double currentWeight, Double maxWeight, TransferDTO transferDTO) {
        List<Cargo> cargoList = new ArrayList<>(cargosLeft);
        List<Cargo> newCurrent = new ArrayList<>(current);
        newCurrent.add(cargosLeft.get(elementAdded));
        cargoList.remove(elementAdded);
        currentWeight += cargosLeft.get(elementAdded).getWeight();
        currentPrice += cargosLeft.get(elementAdded).getCost();
        if (currentWeight <= maxWeight) {
                if (currentPrice > transferDTO.getTotalCost()){
                    transferDTO.setSelectedTransfers(newCurrent);
                    transferDTO.setTotalWeight(currentWeight);
                    transferDTO.setTotalCost(currentPrice);
                }
            for (int i = 0; i < cargoList.size(); i++) {
                recursiveMethod(newCurrent,i,cargoList,currentPrice,currentWeight,maxWeight,transferDTO);
            }
        }
    }
}
