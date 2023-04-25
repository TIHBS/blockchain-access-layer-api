package blockchains.iaas.uni.stuttgart.de.api.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public abstract class ResourceManagerSmartContract extends SmartContract{
    public abstract SmartContractEvent getAbortEvent();
    public abstract SmartContractEvent getVoteEvent();
    public abstract SmartContractFunction getPrepareFunction();
    public abstract SmartContractFunction getAbortFunction();
    public abstract SmartContractFunction getCommitFunction();

    public ResourceManagerSmartContract(String smartContractPath, List<SmartContractFunction> functions, List<SmartContractEvent> events) {
        super(smartContractPath, functions, events);
    }
}
