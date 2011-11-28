/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.accumulo.core.client.impl;

import static org.junit.Assert.assertEquals;

import org.apache.accumulo.core.client.IteratorSetting;
import org.apache.accumulo.core.iterators.user.WholeRowIterator;
import org.junit.Test;

/**
 * Test that scanner options are set/unset correctly
 */
public class ScannerOptionsTest {
  
  /**
   * Test that you properly add and remove iterators from a scanner
   * 
   * @throws Throwable
   */
  @Test
  public void testAddRemoveIterator() throws Throwable {
    ScannerOptions options = new ScannerOptions();
    options.addScanIterator(new IteratorSetting(1, "NAME", WholeRowIterator.class));
    assertEquals(1, options.serverSideIteratorList.size());
    options.removeScanIterator("NAME");
    assertEquals(0, options.serverSideIteratorList.size());
  }
}
