
FROM alpine

# Install Tomcat
FROM tomcat

# Set environment variables
ENV CATALINA_HOME /usr/local/tomcat
ENV PATH $CATALINA_HOME/bin:$PATH

# Set the working directory inside the container
WORKDIR $CATALINA_HOME/webapps

# Copy the WAR file into the container
COPY target/bergerac.war ./ROOT.war

# Expose ports for Tomcat
EXPOSE 8080
EXPOSE 8081

# Set the default command to run Tomcat
CMD ["catalina.sh", "run"]

