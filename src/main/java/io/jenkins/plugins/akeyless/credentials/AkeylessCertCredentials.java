package io.jenkins.plugins.akeyless.credentials;

import com.cloudbees.plugins.credentials.CredentialsScope;
import edu.umd.cs.findbugs.annotations.NonNull;
import hudson.Extension;
import hudson.util.Secret;
import io.akeyless.client.model.Auth;
import javax.annotation.CheckForNull;
import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.DataBoundSetter;

public class AkeylessCertCredentials extends AbstractAkeylessBaseStandardCredentials implements AkeylessCredential {

    @NonNull
    @SuppressWarnings("lgtm[jenkins/plaintext-storage]")
    private String accessId = "";

    @NonNull
    private String certificate = "";

    @NonNull
    private Secret privateKey = Secret.fromString("");

    @DataBoundConstructor
    public AkeylessCertCredentials(
            @CheckForNull CredentialsScope scope, @CheckForNull String id, @CheckForNull String description) {
        super(scope, id, description);
    }

    @NonNull
    public String getAccessId() {
        return accessId;
    }

    @NonNull
    public String getCertificate() {
        return certificate;
    }

    @NonNull
    public Secret getPrivateKey() {
        return privateKey;
    }

    @DataBoundSetter
    public void setAccessId(String accessId) {
        this.accessId = accessId;
    }

    @DataBoundSetter
    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    @DataBoundSetter
    public void setPrivateKey(Secret privateKey) {
        this.privateKey = privateKey;
    }

    public Auth getAuth() {
        Auth auth = new Auth();
        auth.setAccessId(accessId);
        auth.setAccessType("cert");
        auth.setCertData(certificate);
        auth.setKeyData(privateKey.getPlainText());
        return auth;
    }

    @Override
    public CredentialsPayload getCredentialsPayload() {
        CredentialsPayload payload = new CredentialsPayload();
        payload.setAuth(getAuth());
        return payload;
    }

    @Extension
    public static class DescriptorImpl extends BaseStandardCredentialsDescriptor {

        @NonNull
        @Override
        public String getDisplayName() {
            return "Akeyless Certificate";
        }
    }
}
