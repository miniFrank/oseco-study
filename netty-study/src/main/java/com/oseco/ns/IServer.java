package com.oseco.ns;

import java.io.IOException;

/**
 * @author panguanghua
 */
public interface IServer {
    public String getMode();

    public void start() throws IOException;

    public void shutdown();
}
