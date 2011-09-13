/*
 * Copyright (C) 2011 eXo Platform SAS.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.exoplatform.services.jcr.impl.core.query.lucene;

import org.exoplatform.commons.utils.PropertyManager;

import javax.jcr.RepositoryException;

/**
 * Filter returns the value of system property "org.exoplatform.jcr.recoveryfilter.forcereindexing"
 * 
 * @author <a href="mailto:nzamosenchuk@exoplatform.com">Nikolay Zamosenchul</a>
 * @version $Id: SystemPropertyRecoveryFilter.java 34360 2009-07-22 23:58:59Z nzamosenchuk $
 */
public class SystemPropertyRecoveryFilter extends AbstractRecoveryFilter
{

   public static final String FORCE_REINDEXING_RECOVERY_FILTER_PROPERTY =
      "org.exoplatform.jcr.recoveryfilter.forcereindexing";

   /**
    * @param searchIndex
    */
   public SystemPropertyRecoveryFilter(SearchIndex searchIndex)
   {
      super(searchIndex);
   }

   /**
   * {@inheritDoc}
   */
   @Override
   public boolean accept() throws RepositoryException
   {
      return Boolean.valueOf(PropertyManager.getProperty(FORCE_REINDEXING_RECOVERY_FILTER_PROPERTY));
   }
}
