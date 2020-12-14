package com.finalproject.cafegaming.config;


import com.finalproject.cafegaming.model.Photo;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.AbstractInputStreamContent;
import com.google.api.client.http.ByteArrayContent;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.Permission;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.Collections;
import java.util.List;

/**
 * @author AuPhan
 */
@Component
public class GoogleDriveConfig {

    private static final String APPLICATION_NAME = "Google Drive API Java Quickstart";

    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();

    // Directory to store user credentials for this application.
    private static final java.io.File CREDENTIALS_FOLDER //
            = new java.io.File(System.getProperty("user.home"), "credentials");

    private static final String CLIENT_SECRET_FILE_NAME = "/credentials.json";

    private static final List<String> SCOPES = Collections.singletonList(DriveScopes.DRIVE);

    // Global instance of the {@link FileDataStoreFactory}.
    private static FileDataStoreFactory DATA_STORE_FACTORY;

    // Global instance of the HTTP transport.
    private static HttpTransport HTTP_TRANSPORT;

    private static Drive _driveService;

    static {
        try {
            HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
            DATA_STORE_FACTORY = new FileDataStoreFactory(CREDENTIALS_FOLDER);
        } catch (Throwable t) {
            t.printStackTrace();
            System.exit(1);
        }
    }

    public static Credential getCredentials() throws IOException {

        // Load client secrets.
        InputStream in = GoogleDriveConfig.class.getResourceAsStream(CLIENT_SECRET_FILE_NAME);
        if (in == null) {
            throw new FileNotFoundException("Resource not found: " + CLIENT_SECRET_FILE_NAME);
        }
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

        // Build flow and trigger user authorization request.
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                .setDataStoreFactory(new FileDataStoreFactory(new java.io.File("token")))
                .setAccessType("offline")
                .build();
        LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8888).build();
        return new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
    }

    public Drive getDriveService() throws IOException {
        if (_driveService != null) {
            return _driveService;
        }
        Credential credential = getCredentials();
        //
        _driveService = new Drive.Builder(HTTP_TRANSPORT, JSON_FACTORY, credential) //
                .setApplicationName(APPLICATION_NAME).build();
        return _driveService;
    }

    public Photo uploadImage(byte[] imageBytes) throws IOException {
        Drive driveService = getDriveService();
        AbstractInputStreamContent uploadStreamContent = new ByteArrayContent("image/jpeg, image/png", imageBytes);
        File fileMetadata = new File();
        fileMetadata.setName("image.jpg");
        File googleFile = driveService.files().create(fileMetadata, uploadStreamContent)
                .setFields("id, webContentLink, webViewLink, parents").execute();

        System.out.println("Created Google file!");
        System.out.println("WebContentLink: " + googleFile.getWebContentLink() );
        System.out.println("WebViewLink: " + googleFile.getWebViewLink() );
        System.out.println("Done!");

        // All values: user - group - domain - anyone
        String permissionType = "anyone";
        // All values: organizer - owner - writer - commenter - reader
        String permissionRole = "reader";

        Permission newPermission = new Permission();
        newPermission.setType(permissionType);
        newPermission.setRole(permissionRole);
        driveService.permissions().create(googleFile.getId(),newPermission).execute();
        return new Photo("https://drive.google.com/uc?id='" + googleFile.getId() + "'",googleFile.getWebContentLink(),"image",null,null);
    }


}
