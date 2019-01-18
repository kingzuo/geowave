/**
 * Copyright (c) 2013-2019 Contributors to the Eclipse Foundation
 *
 * <p> See the NOTICE file distributed with this work for additional information regarding copyright
 * ownership. All rights reserved. This program and the accompanying materials are made available
 * under the terms of the Apache License, Version 2.0 which accompanies this distribution and is
 * available at http://www.apache.org/licenses/LICENSE-2.0.txt
 */
package org.locationtech.geowave.core.store.operations;

import java.io.Closeable;
import org.apache.log4j.Logger;

public class ReaderClosableWrapper implements Closeable {
  private static final Logger LOGGER = Logger.getLogger(ReaderClosableWrapper.class);
  private final RowReader reader;

  public ReaderClosableWrapper(final RowReader reader) {
    this.reader = reader;
  }

  @Override
  public void close() {
    try {
      reader.close();
    } catch (final Exception e) {
      LOGGER.warn("Unable to close datastore reader", e);
    }
  }
}