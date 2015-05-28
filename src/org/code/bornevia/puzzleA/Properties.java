/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.code.bornevia.puzzleA;

/**
 *
 * @author Satriya
 */
public class Properties {

    public static class Builder {
        private String email;
        private String facebook;
        private String twitter;
        
        public Builder() {
        }
        
        public Properties build() {
            return new Properties(this);
        }
        
        public Builder email(String email) {
            this.email = email;
            return this;
        }
        
        public Builder facebook(String facebook) {
            this.facebook = facebook;
            return this;
        }
        
        public Builder twitter(String twitter) {
            this.twitter = twitter;
            return this;
        }
    }
    
    private final String email;
    private final String facebook;
    private final String twitter;
    
    private Properties(Builder builder) {
        this.email = builder.email;
        this.facebook = builder.facebook;
        this.twitter = builder.twitter;
    }

    public String getEmail() {
        return email;
    }

    public String getFacebook() {
        return facebook;
    }

    public String getTwitter() {
        return twitter;
    }
}