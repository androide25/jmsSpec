/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 1997-2012 Oracle and/or its affiliates. All rights reserved.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License.  You can
 * obtain a copy of the License at
 * https://glassfish.dev.java.net/public/CDDL+GPL_1_1.html
 * or packager/legal/LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 *
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at packager/legal/LICENSE.txt.
 *
 * GPL Classpath Exception:
 * Oracle designates this particular file as subject to the "Classpath"
 * exception as provided by Oracle in the GPL Version 2 section of the License
 * file that accompanied this code.
 *
 * Modifications:
 * If applicable, add the following below the License Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyright [year] [name of copyright owner]"
 *
 * Contributor(s):
 * If you wish your version of this file to be governed by only the CDDL or
 * only the GPL Version 2, indicate your decision by adding "[Contributor]
 * elects to include this software in this distribution under the [CDDL or GPL
 * Version 2] license."  If you don't indicate a single choice of license, a
 * recipient has the option to distribute your version of this file under
 * either the CDDL, the GPL Version 2 or to extend the choice of license to
 * its licensees as provided above.  However, if you add GPL Version 2 code
 * and therefore, elected the GPL Version 2 license, then the option applies
 * only if the new code is made subject to such option by the copyright
 * holder.
 */

package javax.jms;

/** A <CODE>Connection</CODE> object is a client's active connection to its JMS 
  * provider. It typically allocates provider resources outside the Java virtual
  * machine (JVM).
  *
  * <P>Connections support concurrent use.
  *
  * <P>A connection serves several purposes:
  *
  * <UL>
  *   <LI>It encapsulates an open connection with a JMS provider. It 
  *       typically represents an open TCP/IP socket between a client and 
  *       the service provider software.
  *   <LI>Its creation is where client authentication takes place.
  *   <LI>It can specify a unique client identifier.
  *   <LI>It provides a <CODE>ConnectionMetaData</CODE> object.
  *   <LI>It supports an optional <CODE>ExceptionListener</CODE> object.
  * </UL>
  *
  * <P>Because the creation of a connection involves setting up authentication 
  * and communication, a connection is a relatively heavyweight 
  * object. Most clients will do all their messaging with a single connection.
  * Other more advanced applications may use several connections. The JMS API
  * does 
  * not architect a reason for using multiple connections; however, there may 
  * be operational reasons for doing so.
  *
  * <P>A JMS client typically creates a connection, one or more sessions, 
  * and a number of message producers and consumers. When a connection is
  * created, it is in stopped mode. That means that no messages are being
  * delivered.
  *
  * <P>It is typical to leave the connection in stopped mode until setup 
  * is complete (that is, until all message consumers have been 
  * created).  At that point, the client calls 
  * the connection's <CODE>start</CODE> method, and messages begin arriving at 
  * the connection's consumers. This setup
  * convention minimizes any client confusion that may result from 
  * asynchronous message delivery while the client is still in the process 
  * of setting itself up.
  *
  * <P>A connection can be started immediately, and the setup can be done 
  * afterwards. Clients that do this must be prepared to handle asynchronous 
  * message delivery while they are still in the process of setting up.
  *
  * <P>A message producer can send messages while a connection is stopped.
  *
  * @version 2.0
  *
  * @see         javax.jms.ConnectionFactory
  * @see         javax.jms.QueueConnection
  * @see         javax.jms.TopicConnection
  */

public interface Connection extends AutoCloseable {

    /** 
     * Creates a <code>Session</code> object, 
     * specifying <code>transacted</code> and <code>acknowledgeMode</code>.
     * <p>
     * This method has been superseded by the method <code>createSession(int sessionMode)</code>
     * which specifies the same information using a single argument, 
     * and by the method <code>createSession()</code> which is for use in a Java EE JTA transaction.
     * Applications should consider using those methods instead of this one.
     * <p> 
     * The effect of setting the <code>transacted</code> and <code>acknowledgeMode</code> 
     * arguments depends on whether this method is called in a Java SE environment, 
     * in the Java EE application client container, or in the Java EE web or EJB container.
     * If this method is called in the Java EE web or EJB container then the 
     * effect of setting the transacted</code> and <code>acknowledgeMode</code> 
     * arguments also depends on whether or not there is an active JTA transaction 
     * in progress.  
     * <p>
     * In a <b>Java SE environment</b> or in <b>the Java EE application client container</b>:
     * <ul>
     * <li>If <code>transacted</code> is set to <code>true</code> then the session 
     * will use a local transaction which may subsequently be committed or rolled back 
     * by calling the session's <code>commit</code> or <code>rollback</code> methods. 
     * The argument <code>acknowledgeMode</code> is ignored.
     * <li>If <code>transacted</code> is set to <code>false</code> then the session 
     * will be non-transacted. In this case the argument <code>acknowledgeMode</code>
     * is used to specify how messages received by this session will be acknowledged.
     * The permitted values are 
     * <code>Session.CLIENT_ACKNOWLEDGE</code>, 
     * <code>Session.AUTO_ACKNOWLEDGE</code> and
     * <code>Session.DUPS_OK_ACKNOWLEDGE</code>.
     * For a definition of the meaning of these acknowledgement modes see the links below.
     * </ul>
     * <p>
     * In a <b>Java EE web or EJB container, when there is an active JTA transaction in progress</b>:
     * <ul>
     * <li>Both arguments <code>transacted</code> and <code>acknowledgeMode</code> are ignored.
     * The session will participate in the JTA transaction and will be committed or rolled back
     * when that transaction is committed or rolled back, 
     * not by calling the session's <code>commit</code> or <code>rollback</code> methods.
     * Since both arguments are ignored, developers are recommended to use 
     * <code>createSession()</code>, which has no arguments, instead of this method.
     * </ul>
     * <p>
     * In the <b>Java EE web or EJB container, when there is no active JTA transaction in progress</b>:
     * <ul>
     * <li>The argument <code>transacted</code> is ignored. The session will always be non-transacted,
     * using one of the two acknowledgement modes AUTO_ACKNOWLEDGE and DUPS_OK_ACKNOWLEDGE.
     * <li>The argument <code>acknowledgeMode</code>
     * is used to specify how messages received by this session will be acknowledged.
     * The only permitted values in this case are  
     * <code>Session.AUTO_ACKNOWLEDGE</code> and
     * <code>Session.DUPS_OK_ACKNOWLEDGE</code>.
     * The value <code>Session.CLIENT_ACKNOWLEDGE</code> may not be used.
     * For a definition of the meaning of these acknowledgement modes see the links below.
     * </ul> 
     *  
     * @param transacted indicates whether the session will use a local transaction.
     * If this method is called in the Java EE web or EJB container then this argument is ignored.
     * 
     * @param acknowledgeMode indicates how messages received by the session will be acknowledged.
     * <ul>
     * <li>If this method is called in a Java SE environment or in the Java EE application client container, 
     * the permitted values are 
     * <code>Session.CLIENT_ACKNOWLEDGE</code>, 
     * <code>Session.AUTO_ACKNOWLEDGE</code> and
     * <code>Session.DUPS_OK_ACKNOWLEDGE</code>. 
     * <li> If this method is called in the Java EE web or EJB container when there is an active JTA transaction in progress 
     * then this argument is ignored.
     * <li>If this method is called in the Java EE web or EJB container when there is no active JTA transaction in progress, the permitted values are
     * <code>Session.AUTO_ACKNOWLEDGE</code> and
     * <code>Session.DUPS_OK_ACKNOWLEDGE</code>.
     * In this case <code>Session.CLIENT_ACKNOWLEDGE</code> is not permitted.
     * </ul>
     * 
     * @return a newly created  session
     *  
     * @exception JMSException if the <CODE>Connection</CODE> object fails
     *                         to create a session due to some internal error or
     *                         lack of support for the specific transaction
     *                         and acknowledgement mode.
     * @since 1.1
     *
     * @see Session#AUTO_ACKNOWLEDGE 
     * @see Session#CLIENT_ACKNOWLEDGE 
     * @see Session#DUPS_OK_ACKNOWLEDGE 
     * 
     * @see javax.jms.Connection#createSession(int) 
     * @see javax.jms.Connection#createSession() 
     */ 

    Session createSession(boolean transacted, int acknowledgeMode) throws JMSException;
    
     /** 
     * Creates a <code>Session</code> object, specifying <code>sessionMode</code>.
     * <p>
     * The effect of setting the <code>sessionMode</code>  
     * argument depends on whether this method is called in a Java SE environment, 
     * in the Java EE application client container, or in the Java EE web or EJB container.
     * If this method is called in the Java EE web or EJB container then the 
     * effect of setting the <code>sessionMode</code> argument also depends on 
     * whether or not there is an active JTA transaction in progress. 
     * <p>
     * In a <b>Java SE environment</b> or in <b>the Java EE application client container</b>:
     * <ul>
     * <li>If <code>sessionMode</code> is set to <code>Session.SESSION_TRANSACTED</code> then the session 
     * will use a local transaction which may subsequently be committed or rolled back 
     * by calling the session's <code>commit</code> or <code>rollback</code> methods. 
     * <li>If <code>sessionMode</code> is set to any of 
     * <code>Session.CLIENT_ACKNOWLEDGE</code>, 
     * <code>Session.AUTO_ACKNOWLEDGE</code> or
     * <code>Session.DUPS_OK_ACKNOWLEDGE</code>.
     * then the session will be non-transacted and 
     * messages received by this session will be acknowledged
     * according to the value of <code>sessionMode</code>.
     * For a definition of the meaning of these acknowledgement modes see the links below.
     * </ul>
     * <p>
     * In a <b>Java EE web or EJB container, when there is an active JTA transaction in progress</b>:
     * <ul>
     * <li>The argument <code>sessionMode</code> is ignored.
     * The session will participate in the JTA transaction and will be committed or rolled back
     * when that transaction is committed or rolled back, 
     * not by calling the session's <code>commit</code> or <code>rollback</code> methods.
     * Since the argument is ignored, developers are recommended to use 
     * <code>createSession()</code>, which has no arguments, instead of this method.
     * </ul>
     * <p>
     * In the <b>Java EE web or EJB container, when there is no active JTA transaction in progress</b>:
     * <ul>
     * <li>The argument <code>acknowledgeMode</code> must be set to either of 
     * <code>Session.AUTO_ACKNOWLEDGE</code> or
     * <code>Session.DUPS_OK_ACKNOWLEDGE</code>.
     * The session will be non-transacted and messages received by this session will be acknowledged
     * automatically according to the value of <code>acknowledgeMode</code>.
     * For a definition of the meaning of these acknowledgement modes see the links below.
     * The values <code>Session.SESSION_TRANSACTED</code> and <code>Session.CLIENT_ACKNOWLEDGE</code> may not be used.
     * </ul> 
     * 
     * @param sessionMode indicates which of four possible session modes will be used.
     * <ul>
     * <li>If this method is called in a Java SE environment or in the Java EE application client container, 
     * the permitted values are 
     * <code>Session.SESSION_TRANSACTED</code>, 
     * <code>Session.CLIENT_ACKNOWLEDGE</code>, 
     * <code>Session.AUTO_ACKNOWLEDGE</code> and
     * <code>Session.DUPS_OK_ACKNOWLEDGE</code>. 
     * <li> If this method is called in the Java EE web or EJB container when there is an active JTA transaction in progress 
     * then this argument is ignored.
     * <li>If this method is called in the Java EE web or EJB container when there is no active JTA transaction in progress, the permitted values are
     * <code>Session.AUTO_ACKNOWLEDGE</code> and
     * <code>Session.DUPS_OK_ACKNOWLEDGE</code>.
     * In this case the values <code>Session.TRANSACTED</code> and <code>Session.CLIENT_ACKNOWLEDGE</code> are not permitted.
     * </ul>
     * 
     * @return a newly created  session
     *  
     * @exception JMSException if the <CODE>Connection</CODE> object fails
     *                         to create a session due to some internal error or
     *                         lack of support for the specific transaction
     *                         and acknowledgement mode.
     * @since 2.0
     *
     * @see Session#SESSION_TRANSACTED 
     * @see Session#AUTO_ACKNOWLEDGE 
     * @see Session#CLIENT_ACKNOWLEDGE 
     * @see Session#DUPS_OK_ACKNOWLEDGE 
     * 
     * @see javax.jms.Connection#createSession(boolean, int) 
     * @see javax.jms.Connection#createSession() 
     */   
    Session createSession(int sessionMode) throws JMSException;
                       
    /** 
     * Creates a <code>Session</code> object, 
     * specifying no arguments.
     * <p>
     * The behaviour of the session that is created depends on 
     * whether this method is called in a Java SE environment, 
     * in the Java EE application client container, or in the Java EE web or EJB container.
     * If this method is called in the Java EE web or EJB container then the 
     * behaviour of the session also depends on whether or not 
     * there is an active JTA transaction in progress.   
     * <p>
     * In a <b>Java SE environment</b> or in <b>the Java EE application client container</b>:
     * <ul>
     * <li>The session will be non-transacted and received messages will be acknowledged automatically
     * using an acknowledgement mode of <code>Session.AUTO_ACKNOWLEDGE</code> 
     * For a definition of the meaning of this acknowledgement mode see the link below.
     * </ul>
     * <p>
     * In a <b>Java EE web or EJB container, when there is an active JTA transaction in progress</b>:
     * <ul>
     * <li>The session will participate in the JTA transaction and will be committed or rolled back
     * when that transaction is committed or rolled back, 
     * not by calling the session's <code>commit</code> or <code>rollback</code> methods.
     * </ul>
     * <p>
     * In the <b>Java EE web or EJB container, when there is no active JTA transaction in progress</b>:
     * <ul>
     * <li>The session will be non-transacted and received messages will be acknowledged automatically
     * using an acknowledgement mode of <code>Session.AUTO_ACKNOWLEDGE</code> 
     * For a definition of the meaning of this acknowledgement mode see the link below.
     * </ul> 
     *  
     * @return a newly created  session
     *  
     * @exception JMSException if the <CODE>Connection</CODE> object fails
     *                         to create a session due to some internal error.
     *                       
     * @since 2.0
     *
     * @see Session#AUTO_ACKNOWLEDGE 
     * 
     * @see javax.jms.Connection#createSession(boolean, int) 
     * @see javax.jms.Connection#createSession(int) 
     */ 

    Session createSession() throws JMSException;    
    
    
    /** Gets the client identifier for this connection.
      *  
      * <P>This value is specific to the JMS provider.  It is either preconfigured 
      * by an administrator in a <CODE>ConnectionFactory</CODE> object
      * or assigned dynamically by the application by calling the
      * <code>setClientID</code> method.
      * 
      * 
      * @return the unique client identifier
      *  
      * @exception JMSException if the JMS provider fails to return
      *                         the client ID for this connection due
      *                         to some internal error.
      *
      **/
    String
    getClientID() throws JMSException;


    /** Sets the client identifier for this connection.
      *  
      * <P>The preferred way to assign a JMS client's client identifier is for
      * it to be configured in a client-specific <CODE>ConnectionFactory</CODE>
      * object and transparently assigned to the <CODE>Connection</CODE> object
      * it creates.
      * 
      * <P>Alternatively, a client can set a connection's client identifier
      * using a provider-specific value. The facility to set a connection's
      * client identifier explicitly is not a mechanism for overriding the
      * identifier that has been administratively configured. It is provided
      * for the case where no administratively specified identifier exists.
      * If one does exist, an attempt to change it by setting it must throw an
      * <CODE>IllegalStateException</CODE>. If a client sets the client identifier
      * explicitly, it must do so immediately after it creates the connection 
      * and before any other
      * action on the connection is taken. After this point, setting the
      * client identifier is a programming error that should throw an
      * <CODE>IllegalStateException</CODE>.
      *
      * <P>The purpose of the client identifier is to associate a connection and
      * its objects with a state maintained on behalf of the client by a 
      * provider. The only such state identified by the JMS API is that required
      * to support durable subscriptions.
      *
      * <P>If another connection with the same <code>clientID</code> is already running when
      * this method is called, the JMS provider should detect the duplicate ID and throw
      * an <CODE>InvalidClientIDException</CODE>.
      *
      * @param clientID the unique client identifier
      * 
      * @exception JMSException if the JMS provider fails to
      *                         set the client ID for this connection due
      *                         to some internal error.
      *
      * @exception InvalidClientIDException if the JMS client specifies an
      *                         invalid or duplicate client ID.
      * @exception IllegalStateException if the JMS client attempts to set
      *       a connection's client ID at the wrong time or
      *       when it has been administratively configured.
      */

    void
    setClientID(String clientID) throws JMSException;

 
    /** Gets the metadata for this connection.
      *  
      * @return the connection metadata
      *  
      * @exception JMSException if the JMS provider fails to
      *                         get the connection metadata for this connection.
      *
      * @see javax.jms.ConnectionMetaData
      */

    ConnectionMetaData
    getMetaData() throws JMSException;

    /**
     * Gets the <CODE>ExceptionListener</CODE> object for this connection. 
     * Not every <CODE>Connection</CODE> has an <CODE>ExceptionListener</CODE>
     * associated with it.
     *
     * @return the <CODE>ExceptionListener</CODE> for this connection, or null. 
     *              if no <CODE>ExceptionListener</CODE> is associated
     *              with this connection.
     *
     * @exception JMSException if the JMS provider fails to
     *                         get the <CODE>ExceptionListener</CODE> for this 
     *                         connection. 
     * @see javax.jms.Connection#setExceptionListener
     */

    ExceptionListener 
    getExceptionListener() throws JMSException;


    /** Sets an exception listener for this connection.
      *
      * <P>If a JMS provider detects a serious problem with a connection, it
      * informs the connection's <CODE>ExceptionListener</CODE>, if one has been
      * registered. It does this by calling the listener's
      * <CODE>onException</CODE> method, passing it a <CODE>JMSException</CODE>
      * object describing the problem.
      *
      * <P>An exception listener allows a client to be notified of a problem
      * asynchronously.
      * Some connections only consume messages, so they would have no other 
      * way to learn their connection has failed.
      *
      * <P>A connection serializes execution of its
      * <CODE>ExceptionListener</CODE>.
      *
      * <P>A JMS provider should attempt to resolve connection problems 
      * itself before it notifies the client of them.
      *
      * @param listener the exception listener
      *
      * @exception JMSException if the JMS provider fails to
      *                         set the exception listener for this connection.
      *
      */

    void 
    setExceptionListener(ExceptionListener listener) throws JMSException;

    /** Starts (or restarts) a connection's delivery of incoming messages.
      * A call to <CODE>start</CODE> on a connection that has already been
      * started is ignored.
      * 
      * @exception JMSException if the JMS provider fails to start
      *                         message delivery due to some internal error.
      *
      * @see javax.jms.Connection#stop
      */

    void
    start() throws JMSException;

 
    /** Temporarily stops a connection's delivery of incoming messages.
      * Delivery can be restarted using the connection's <CODE>start</CODE>
      * method. When the connection is stopped,
      * delivery to all the connection's message consumers is inhibited:
      * synchronous receives block, and messages are not delivered to message
      * listeners.
      *
      * <P>This call blocks until receives and/or message listeners in progress
      * have completed.
      *
      * <P>Stopping a connection has no effect on its ability to send messages.
      * A call to <CODE>stop</CODE> on a connection that has already been
      * stopped is ignored.
      *
      * <P>A call to <CODE>stop</CODE> must not return until delivery of messages
      * has paused. This means that a client can rely on the fact that none of 
      * its message listeners will be called and that all threads of control 
      * waiting for <CODE>receive</CODE> calls to return will not return with a 
      * message until the
      * connection is restarted. The receive timers for a stopped connection
      * continue to advance, so receives may time out while the connection is
      * stopped.
      * 
      * <P>If message listeners are running when <CODE>stop</CODE> is invoked, 
      * the <CODE>stop</CODE> call must
      * wait until all of them have returned before it may return. While these
      * message listeners are completing, they must have the full services of the
      * connection available to them.
      * <p>
      * A message listener must not attempt to stop its own connection as this 
      * would lead to deadlock. The JMS provider must detect this and throw a 
      * javax.jms.IllegalStateException.
      * <p>
      * For the avoidance of doubt, if an exception listener for this connection 
      * is running when <code>stop</code> is invoked, there is no requirement for 
      * the <code>stop</code> call to wait until the exception listener has returned
      * before it may return. 
      *  
      * @exception JMSException if the JMS provider fails to stop
      *                         message delivery due to some internal error.
      *
      * @see javax.jms.Connection#start
      */

    void
    stop() throws JMSException;

 
    /** Closes the connection.
      *
      * <P>Since a provider typically allocates significant resources outside 
      * the JVM on behalf of a connection, clients should close these resources
      * when they are not needed. Relying on garbage collection to eventually 
      * reclaim these resources may not be timely enough.
      *
      * <P>There is no need to close the sessions, producers, and consumers
      * of a closed connection.
      *
      * <P>Closing a connection causes all temporary destinations to be
      * deleted.
      *
      * <P>When this method is invoked, it should not return until message
      * processing has been shut down in an orderly fashion. This means that all
      * message 
      * listeners that may have been running have returned, and that all pending 
      * receives have returned. A close terminates all pending message receives 
      * on the connection's sessions' consumers. The receives may return with a 
      * message or with null, depending on whether there was a message available 
      * at the time of the close. If one or more of the connection's sessions' 
      * message listeners is processing a message at the time when connection 
      * <CODE>close</CODE> is invoked, all the facilities of the connection and 
      * its sessions must remain available to those listeners until they return 
      * control to the JMS provider. 
      * <p>
      * A message listener must not attempt to close its own connection as this 
      * would lead to deadlock. The JMS provider must detect this and throw a 
      * javax.jms.IllegalStateException.
      * <p>
      * For the avoidance of doubt, if an exception listener for this connection 
      * is running when <code>close</code> is invoked, there is no requirement for 
      * the <code>close</code> call to wait until the exception listener has returned
      * before it may return. 
      * 
      * <P>Closing a connection causes any of its sessions' transactions
      * in progress to be rolled back. In the case where a session's
      * work is coordinated by an external transaction manager, a session's 
      * <CODE>commit</CODE> and <CODE>rollback</CODE> methods are
      * not used and the result of a closed session's work is determined
      * later by the transaction manager.
      *
      * Closing a connection does NOT force an 
      * acknowledgment of client-acknowledged sessions. 
      * 
      * <P>Invoking the <CODE>acknowledge</CODE> method of a received message 
      * from a closed connection's session must throw an 
      * <CODE>IllegalStateException</CODE>.  Closing a closed connection must 
      * NOT throw an exception.
      *  
      * @exception JMSException if the JMS provider fails to close the
      *                         connection due to some internal error. For 
      *                         example, a failure to release resources
      *                         or to close a socket connection can cause
      *                         this exception to be thrown.
      *                         
      */

    void 
    close() throws JMSException; 
    
      /** Creates a connection consumer for this connection (optional operation).
      * This is an expert facility not used by regular JMS clients.
      *  
      * @param destination the destination to access
      * @param messageSelector only messages with properties matching the
      * message selector expression are delivered.  A value of null or
      * an empty string indicates that there is no message selector  
      * for the message consumer.
      * @param sessionPool the server session pool to associate with this 
      * connection consumer
      * @param maxMessages the maximum number of messages that can be
      * assigned to a server session at one time
      *
      * @return the connection consumer
      *
      * @exception JMSException if the <CODE>Connection</CODE> object fails
      *                         to create a connection consumer due to some
      *                         internal error or invalid arguments for 
      *                         <CODE>sessionPool</CODE> and 
      *                         <CODE>messageSelector</CODE>.
      * @exception InvalidDestinationException if an invalid destination is specified.
      * @exception InvalidSelectorException if the message selector is invalid.
      *
      * @since 1.1
      * @see javax.jms.ConnectionConsumer
      */ 

    ConnectionConsumer
    createConnectionConsumer(Destination destination,
                             String messageSelector,
                             ServerSessionPool sessionPool,
			     int maxMessages)
			     throws JMSException;


    /** Create a durable connection consumer for this connection (optional operation). 
      * This is an expert facility not used by regular JMS clients.
      *                
      * @param topic topic to access
      * @param subscriptionName durable subscription name
      * @param messageSelector only messages with properties matching the
      * message selector expression are delivered.  A value of null or
      * an empty string indicates that there is no message selector 
      * for the message consumer.
      * @param sessionPool the server session pool to associate with this 
      * durable connection consumer
      * @param maxMessages the maximum number of messages that can be
      * assigned to a server session at one time
      *
      * @return the durable connection consumer
      *  
      * @exception JMSException if the <CODE>Connection</CODE> object fails
      *                         to create a connection consumer due to some
      *                         internal error or invalid arguments for 
      *                         <CODE>sessionPool</CODE> and 
      *                         <CODE>messageSelector</CODE>.
      * @exception InvalidDestinationException if an invalid destination
      *             is specified.
      * @exception InvalidSelectorException if the message selector is invalid.
      * @since 1.1
      * @see javax.jms.ConnectionConsumer
      */

    ConnectionConsumer
    createDurableConnectionConsumer(Topic topic,
				    String subscriptionName,
                                    String messageSelector,
                                    ServerSessionPool sessionPool,
				    int maxMessages)
                             throws JMSException;
          
}

