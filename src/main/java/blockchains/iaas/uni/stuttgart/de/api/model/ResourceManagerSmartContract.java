package blockchains.iaas.uni.stuttgart.de.api.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
public abstract class ResourceManagerSmartContract extends SmartContract{
    abstract SmartContractEvent getAbortEvent();
    abstract SmartContractEvent getVoteEvent();
    abstract SmartContractFunction getPrepareFunction();
    abstract SmartContractFunction getAbortFunction();
    abstract SmartContractFunction getCommitFunction();
}
