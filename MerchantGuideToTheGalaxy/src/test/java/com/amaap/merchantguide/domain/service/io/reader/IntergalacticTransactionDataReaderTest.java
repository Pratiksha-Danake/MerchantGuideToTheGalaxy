package com.amaap.merchantguide.domain.service.io.reader;

import com.amaap.merchantguide.domain.service.io.reader.validator.InputLineValidator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class IntergalacticTransactionDataReaderTest {
    IntergalacticTransactionDataReader intergalacticTransactionDataReader;

    @BeforeAll
    void setUp() {
        intergalacticTransactionDataReader = new IntergalacticTransactionDataReader(new InputLineValidator());
    }

    @Test
    void shouldBeAbleToReturnTrueIfGetsReadIntergalacticTransactionDataFile() throws IOException {
        // arrange
        File file = new File("E:\\MerchantGuideToTheGalaxy\\MerchantGuideToTheGalaxy\\src\\main\\java\\resources\\IntergalacticTransactionData");

        // act && assert
        assertTrue(intergalacticTransactionDataReader.readTransactionData(file));
    }

    @Test
    void shouldThrowFileNotFoundExceptionIfFileNotFoundAtSpecifiedPath() throws IOException {
        // arrange
        File file = new File("E:\\MerchantGuideToTheGalaxy\\MerchantGuideToTheGalaxy\\src\\main\\java\\resources\\InvalidTransactionData");

        // act && assert
        assertThrows(FileNotFoundException.class, () -> intergalacticTransactionDataReader.readTransactionData(file));
    }
}