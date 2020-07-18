package com.martins;

import io.micronaut.function.FunctionBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Function;

@FunctionBean("vies-vat-validator")
public class ViesVatValidatorFunction
        implements Function<VatValidationRequest, VatValidation> {
    private static final Logger LOG = LoggerFactory.getLogger(ViesVatValidatorFunction.class);

    private final VatService vatService;

    public ViesVatValidatorFunction(VatService vatService) {
        this.vatService = vatService;
    }

    @Override
    public VatValidation apply(VatValidationRequest request) {
        final String memberStateCode = request.getMemberStateCode();
        final String vatNumber = request.getVatNumber();
        if (LOG.isDebugEnabled()) {
            LOG.debug("validate country: {} vat number: {}", memberStateCode, vatNumber);
        }
        return vatService.validateVat(memberStateCode, vatNumber)
                .map(valid -> new VatValidation(memberStateCode, vatNumber, valid))
                .blockingGet();
    }
}