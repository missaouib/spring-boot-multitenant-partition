package top.wisely.tenancy.config;


import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.springframework.stereotype.Component;

/**
 * JPA Attribute Converter for encrypting and decrypting String attributes. This
 * converter uses the Jasypt library for encryption and decryption operations.
 * It is configured with an environment variable for the encryption password.
 *
 * Note: Ensure that the Jasypt library is correctly configured in your project.
 * The encryption password should be provided through the
 * "jasypt.encryptor.password" property.
 *
 * @author rahul.chauhan
 */
@Converter
public class TextEncryptorConverter implements AttributeConverter<String, String> {

    private static final String ENCRYPTION_PASSWORD_PROPERTY = "jasypt.encryptor.password";

    private final StandardPBEStringEncryptor encryptor;

    /**
     * Constructor for StringCryptoConverter.
     *
     * @param environment The Spring Environment used to access properties.
     */
    public TextEncryptorConverter(Environment environment) {
        // Initialize the encryptor with the encryption password from the environment
        this.encryptor = new StandardPBEStringEncryptor();
        this.encryptor.setPassword(environment.getProperty(ENCRYPTION_PASSWORD_PROPERTY));
    }

    /**
     * Converts the attribute value to the encrypted form.
     *
     * @param attribute The original attribute value to be encrypted.
     * @return The encrypted form of the attribute.
     */
    @Override
    public String convertToDatabaseColumn(String attribute) {
        return encryptor.encrypt(attribute);
    }

    /**
     * Converts the encrypted database value to its decrypted form.
     *
     * @param dbData The encrypted value stored in the database.
     * @return The decrypted form of the database value.
     */
    @Override
    public String convertToEntityAttribute(String dbData) {
        return encryptor.decrypt(dbData);
    }
}
