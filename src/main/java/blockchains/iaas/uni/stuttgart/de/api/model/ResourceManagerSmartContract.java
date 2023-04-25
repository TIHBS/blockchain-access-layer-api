package blockchains.iaas.uni.stuttgart.de.api.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
public abstract class ResourceManagerSmartContract extends SmartContract{
    public abstract SmartContractEvent getAbortEvent();
    public abstract SmartContractEvent getVoteEvent();
    public abstract SmartContractFunction getPrepareFunction();
    public abstract SmartContractFunction getAbortFunction();
    public abstract SmartContractFunction getCommitFunction();
}
