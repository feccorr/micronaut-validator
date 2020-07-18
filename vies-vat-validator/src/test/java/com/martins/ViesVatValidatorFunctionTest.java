package com.martins;

import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@MicronautTest
public class ViesVatValidatorFunctionTest {

    @Inject
    ViesVatValidatorClient client;

    @Test
    public void testViesVatValidatorFunction() throws Exception {
        VatValidationRequest req = new VatValidationRequest("es", "B99286353");
        assertTrue(client.apply(req).blockingGet().isValid());

        req = new VatValidationRequest("es", "B19280031");
        assertTrue(client.apply(req).blockingGet().isValid());

        req = new VatValidationRequest("es", "XXXXXXXXX");
        assertFalse(client.apply(req).blockingGet().isValid());
    }
}
