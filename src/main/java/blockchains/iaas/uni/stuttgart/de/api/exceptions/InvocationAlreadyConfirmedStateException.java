package blockchains.iaas.uni.stuttgart.de.api.exceptions;

public class InvocationAlreadyConfirmedStateException extends BalException {
    @Override
    public int getCode() {
        return ExceptionCode.InvocationAlreadyConfirmed;
    }

    public InvocationAlreadyConfirmedStateException() {
    }

    public InvocationAlreadyConfirmedStateException(String message) {
        super(message);
    }
}
