/*
 * Copyright (C) 2003-2010 eXo Platform SAS.
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Affero General Public License
 * as published by the Free Software Foundation; either version 3
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, see<http://www.gnu.org/licenses/>.
 */
package org.exoplatform.services.jcr.impl.util.jdbc.cleaner;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:anatoliy.bazko@gmail.com">Anatoliy Bazko</a>
 * @version $Id$
 */
public class MultiDBCleaner extends WorkspaceDBCleaner
{

   /**
    * Common clean scripts for multi database.
    */
   protected final List<String> commonMutliDBCleanScripts = new ArrayList<String>();

   /**
    * MultiDBCleaner constructor.
    */
   public MultiDBCleaner(String containerName, Connection connection)
   {
      super(containerName, connection);

      commonMutliDBCleanScripts.add("drop table JCR_MREF");
      commonMutliDBCleanScripts.add("drop table JCR_MVALUE");
      commonMutliDBCleanScripts.add("drop table JCR_MITEM");
      commonMutliDBCleanScripts.add("drop table JCR_LOCK_" + containerName.toUpperCase());
      commonMutliDBCleanScripts.add("drop table JCR_LOCK_" + containerName.toUpperCase() + "_D");
   }

   /**
    * {@inheritDoc}
    */
   @Override
   protected List<String> getDBCleanScripts()
   {
      return commonMutliDBCleanScripts;
   }
}
