/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2016 Datapipe, Inc.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package io.jenkins.plugins.akeyless.model;

import static hudson.Util.fixEmptyAndTrim;

import hudson.Extension;
import hudson.model.AbstractDescribableImpl;
import hudson.model.Descriptor;
import java.util.List;
import org.kohsuke.stapler.DataBoundConstructor;

/**
 * @author alexeydolgopyatov
 */
public class AkeylessSecret extends AbstractDescribableImpl<AkeylessSecret> implements AkeylessSecretBase {

    private String path;
    private List<AkeylessSecretValue> secretValues;

    @DataBoundConstructor
    public AkeylessSecret(String path, List<AkeylessSecretValue> secretValues) {
        this.path = fixEmptyAndTrim(path);
        this.secretValues = secretValues;
    }

    public String getPath() {
        return this.path;
    }

    public List<AkeylessSecretValue> getSecretValues() {
        return this.secretValues;
    }

    @Extension
    public static final class DescriptorImpl extends Descriptor<AkeylessSecret> {

        @Override
        public String getDisplayName() {
            return "Akeyless Secret";
        }
    }
}
