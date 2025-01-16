package ec.com.sofka.queries.usecases;

import ec.com.sofka.gateway.IErrorLogRepository;
import ec.com.sofka.model.ErrorMessage;
import ec.com.sofka.generics.interfaces.IUseCaseAccept;
import org.springframework.stereotype.Service;

@Service
public class ErrorLogSavedViewUseCase implements IUseCaseAccept<ErrorMessage> {
    private final IErrorLogRepository errorLogRepository;

    public ErrorLogSavedViewUseCase(IErrorLogRepository errorLogRepository) {
        this.errorLogRepository = errorLogRepository;
    }

    @Override
    public void accept(ErrorMessage errorMessage) {
        errorLogRepository.save(errorMessage)
                .subscribe();
    }
}
