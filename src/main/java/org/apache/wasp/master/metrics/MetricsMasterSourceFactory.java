/**
 * Copyright The Apache Software Foundation
 *
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with this
 * work for additional information regarding copyright ownership. The ASF
 * licenses this file to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package org.apache.wasp.master.metrics;

import org.apache.wasp.master.MetricsMasterSourceImpl;

/**
 * Factory to create MetricsMasterSource when given a MetricsMasterWrapper
 */
public class MetricsMasterSourceFactory {
  private static enum FactoryStorage {
    INSTANCE;
    MetricsMasterSource masterSource;
  }

  public static synchronized MetricsMasterSource create(
      MetricsMasterWrapper masterWrapper) {
    if (FactoryStorage.INSTANCE.masterSource == null) {
      FactoryStorage.INSTANCE.masterSource = new MetricsMasterSourceImpl(
          masterWrapper);
    }
    return FactoryStorage.INSTANCE.masterSource;
  }
}
