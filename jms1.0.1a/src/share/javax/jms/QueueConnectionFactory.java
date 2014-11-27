
/*
 * @(#)QueueConnectionFactory.java	1.8 98/10/07
 * 
 * Copyright (c) 1997-1998 Sun Microsystems, Inc. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Sun
 * Microsystems, Inc. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Sun.
 * 
 * SUN MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF THE
 * SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR
 * PURPOSE, OR NON-INFRINGEMENT. SUN SHALL NOT BE LIABLE FOR ANY DAMAGES
 * SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING OR DISTRIBUTING
 * THIS SOFTWARE OR ITS DERIVATIVES.
 * 
 */

package javax.jms;

/** A client uses a QueueConnectionFactory to create QueueConnections with 
  * a JMS PTP provider.
  *
  * @version     1.0 - 14 May 1998
  * @author      Mark Hapner
  * @author      Rich Burridge
  *
  * @see         javax.jms.ConnectionFactory
  */

public interface QueueConnectionFactory extends ConnectionFactory {

    /** Create a queue connection with default user identity.
      *
      * @return a newly created queue connection.
      *
      * @exception JMSException if JMS Provider fails to create Queue Connection
      *                         due to some internal error.
      *                         required resources for a Queue Connection.
      * @exception JMSSecurityException  if client authentication fails due to 
      *                         invalid user name or password.
      */ 

    QueueConnection
    createQueueConnection() throws JMSException;


    /** Create a queue connection with specified user identity.
      *  
      * @param userName the caller's user name
      * @param password the caller's password
      *  
      * @return a newly created queue connection.
      *
      * @exception JMSException if JMS Provider fails to create Queue Connection
      *                         due to some internal error.
      * @exception JMSSecurityException  if client authentication fails due to 
      *                         invalid user name or password.
      */ 

    QueueConnection
    createQueueConnection(String userName, String password) 
					     throws JMSException;
}
