package net.sf.jsignpdf;

import java.net.Proxy;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComponent;

import net.sf.jsignpdf.utils.ConvertUtils;
import net.sf.jsignpdf.utils.ResourceProvider;

/**
 * JDialog for setting timestamp authority and enabling OCSP.
 * 
 * @author Josef Cacek
 */
public class TsaDialog extends javax.swing.JDialog {

	private static final long serialVersionUID = 1L;

	protected final ResourceProvider res = ResourceProvider.getInstance();
	private BasicSignerOptions options;

	/** Creates new form TsaDialog */
	public TsaDialog(java.awt.Frame parent, boolean modal, BasicSignerOptions anOpts) {
		super(parent, modal);
		options = anOpts;
		initComponents();
		getRootPane().setDefaultButton(btnTsaOK);
		cbProxyType.setModel(new DefaultComboBoxModel(Proxy.Type.values()));
		translateLabels();
		switchTsaEnabled();
	}

	/**
	 * Translates labels in this dialog.
	 */
	private void translateLabels() {
		setTitle(res.get("gui.tsa.title"));

		setLabelAndMnemonic(chkbTsaEnabled, "gui.tsa.enabled.checkbox");

		setLabelAndMnemonic(lblTsaUrl, "gui.tsa.url.label");
		setLabelAndMnemonic(lblTsaUser, "gui.tsa.user.label");
		setLabelAndMnemonic(lblTsaPwd, "gui.tsa.pwd.label");

		setLabelAndMnemonic(chkbOcspEnabled, "gui.tsa.ocspEnabled.checkbox");
		setLabelAndMnemonic(chkbCrlEnabled, "gui.tsa.crlEnabled.checkbox");

		setLabelAndMnemonic(pnlProxy, "gui.tsa.proxy.panel");
		setLabelAndMnemonic(lblProxyType, "gui.tsa.proxyType.label");
		setLabelAndMnemonic(lblProxyHost, "gui.tsa.proxyHost.label");
	}

	/**
	 * Loads properties saved by previous run of application
	 */
	private void updateFromOptions() {
		chkbTsaEnabled.setSelected(options.isTimestamp());
		tfTsaUrl.setText(ConvertUtils.toString(options.getTsaUrl()));
		tfTsaUser.setText(ConvertUtils.toString(options.getTsaUser()));
		pfTsaPwd.setText(ConvertUtils.toString(options.getTsaPasswd()));
		chkbOcspEnabled.setSelected(options.isOcspEnabled());
		chkbCrlEnabled.setSelected(options.isCrlEnabled());
		cbProxyType.setSelectedItem(options.getProxyType());
		tfProxyHost.setText(options.getProxyHost());
		spProxyPort.setValue(Integer.valueOf(options.getProxyPort()));
	}

	/**
	 * Enabling text field
	 */
	private void switchTsaEnabled() {
		boolean tmpEnabled = chkbTsaEnabled.isSelected();
		tfTsaUrl.setEnabled(tmpEnabled);
		tfTsaUser.setEnabled(tmpEnabled);
		pfTsaPwd.setEnabled(tmpEnabled);
	}

	/**
	 * stores values from this Form to the instance of {@link SignerOptions}
	 */
	private void storeToOptions() {
		options.setTimestamp(chkbTsaEnabled.isSelected());
		options.setTsaUrl(tfTsaUrl.getText());
		options.setTsaUser(tfTsaUser.getText());
		options.setTsaPasswd(new String(pfTsaPwd.getPassword()));
		options.setOcspEnabled(chkbOcspEnabled.isSelected());
		options.setCrlEnabled(chkbCrlEnabled.isSelected());

		options.setProxyType((Proxy.Type) cbProxyType.getSelectedItem());
		options.setProxyHost(tfProxyHost.getText());
		options.setProxyPort(((Integer) spProxyPort.getValue()).intValue());
		// if there are fixed values update them in the form;
		updateFromOptions();
	}

	/**
	 * Facade for
	 * {@link ResourceProvider#setLabelAndMnemonic(JComponent, String)}
	 * 
	 * @param aComponent
	 * @param aKey
	 */
	private void setLabelAndMnemonic(final JComponent aComponent, final String aKey) {
		res.setLabelAndMnemonic(aComponent, aKey);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	// <editor-fold defaultstate="collapsed"
	// <editor-fold defaultstate="collapsed"
	// desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {
		java.awt.GridBagConstraints gridBagConstraints;

		chkbTsaEnabled = new javax.swing.JCheckBox();
		lblTsaUrl = new javax.swing.JLabel();
		tfTsaUrl = new javax.swing.JTextField();
		lblTsaUser = new javax.swing.JLabel();
		lblTsaPwd = new javax.swing.JLabel();
		tfTsaUser = new javax.swing.JTextField();
		pfTsaPwd = new javax.swing.JPasswordField();
		chkbOcspEnabled = new javax.swing.JCheckBox();
		btnTsaOK = new javax.swing.JButton();
		chkbCrlEnabled = new javax.swing.JCheckBox();
		pnlProxy = new javax.swing.JPanel();
		lblProxyHost = new javax.swing.JLabel();
		tfProxyHost = new javax.swing.JTextField();
		lblProxyType = new javax.swing.JLabel();
		cbProxyType = new javax.swing.JComboBox();
		spProxyPort = new javax.swing.JSpinner();

		addComponentListener(new java.awt.event.ComponentAdapter() {
			public void componentHidden(java.awt.event.ComponentEvent evt) {
				formComponentHidden(evt);
			}

			public void componentShown(java.awt.event.ComponentEvent evt) {
				formComponentShown(evt);
			}
		});
		getContentPane().setLayout(new java.awt.GridBagLayout());

		chkbTsaEnabled.setText("Use timestamp server");
		chkbTsaEnabled.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
		chkbTsaEnabled.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				chkbTsaEnabledActionPerformed(evt);
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints.insets = new java.awt.Insets(2, 5, 2, 5);
		getContentPane().add(chkbTsaEnabled, gridBagConstraints);

		lblTsaUrl.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		lblTsaUrl.setLabelFor(tfTsaUrl);
		lblTsaUrl.setText("TSA URL");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints.weightx = 1.0;
		gridBagConstraints.insets = new java.awt.Insets(2, 5, 2, 5);
		getContentPane().add(lblTsaUrl, gridBagConstraints);

		tfTsaUrl.setMinimumSize(new java.awt.Dimension(200, 20));
		tfTsaUrl.setPreferredSize(new java.awt.Dimension(200, 20));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints.weightx = 4.0;
		gridBagConstraints.insets = new java.awt.Insets(2, 5, 2, 5);
		getContentPane().add(tfTsaUrl, gridBagConstraints);

		lblTsaUser.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		lblTsaUser.setLabelFor(tfTsaUser);
		lblTsaUser.setText("TSA user");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints.insets = new java.awt.Insets(2, 5, 2, 5);
		getContentPane().add(lblTsaUser, gridBagConstraints);

		lblTsaPwd.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		lblTsaPwd.setLabelFor(lblTsaPwd);
		lblTsaPwd.setText("TSA password");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints.insets = new java.awt.Insets(2, 5, 2, 5);
		getContentPane().add(lblTsaPwd, gridBagConstraints);

		tfTsaUser.setMinimumSize(new java.awt.Dimension(70, 20));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints.insets = new java.awt.Insets(2, 5, 2, 5);
		getContentPane().add(tfTsaUser, gridBagConstraints);
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints.insets = new java.awt.Insets(2, 5, 2, 5);
		getContentPane().add(pfTsaPwd, gridBagConstraints);

		chkbOcspEnabled.setText("Use OCSP");
		chkbOcspEnabled.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 4;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints.insets = new java.awt.Insets(2, 5, 2, 5);
		getContentPane().add(chkbOcspEnabled, gridBagConstraints);

		btnTsaOK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/sf/jsignpdf/back16.png"))); // NOI18N
		btnTsaOK.setText("OK");
		btnTsaOK.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnTsaOKActionPerformed(evt);
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 7;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
		gridBagConstraints.insets = new java.awt.Insets(7, 2, 2, 5);
		getContentPane().add(btnTsaOK, gridBagConstraints);

		chkbCrlEnabled.setText("Use CRL");
		chkbCrlEnabled.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 5;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints.insets = new java.awt.Insets(2, 5, 2, 5);
		getContentPane().add(chkbCrlEnabled, gridBagConstraints);

		pnlProxy.setBorder(javax.swing.BorderFactory.createTitledBorder("Proxy"));
		pnlProxy.setLayout(new java.awt.GridBagLayout());

		lblProxyHost.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		lblProxyHost.setLabelFor(tfProxyHost);
		lblProxyHost.setText("Proxy host/port");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints.weightx = 1.0;
		gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 5);
		pnlProxy.add(lblProxyHost, gridBagConstraints);

		tfProxyHost.setMinimumSize(new java.awt.Dimension(200, 20));
		tfProxyHost.setPreferredSize(new java.awt.Dimension(200, 20));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints.weightx = 4.0;
		gridBagConstraints.insets = new java.awt.Insets(2, 5, 2, 2);
		pnlProxy.add(tfProxyHost, gridBagConstraints);

		lblProxyType.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		lblProxyType.setLabelFor(cbProxyType);
		lblProxyType.setText("Proxy type");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints.weightx = 1.0;
		gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 5);
		pnlProxy.add(lblProxyType, gridBagConstraints);

		cbProxyType.setMinimumSize(new java.awt.Dimension(150, 20));
		cbProxyType.setPreferredSize(new java.awt.Dimension(150, 20));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints.insets = new java.awt.Insets(2, 5, 2, 2);
		pnlProxy.add(cbProxyType, gridBagConstraints);

		spProxyPort.setModel(new javax.swing.SpinnerNumberModel(80, 0, 65535, 1));
		spProxyPort.setMinimumSize(new java.awt.Dimension(50, 18));
		spProxyPort.setPreferredSize(new java.awt.Dimension(50, 18));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
		pnlProxy.add(spProxyPort, gridBagConstraints);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 6;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		getContentPane().add(pnlProxy, gridBagConstraints);
	}// </editor-fold>//GEN-END:initComponents

	private void btnTsaOKActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnTsaOKActionPerformed
		setVisible(false);
	}// GEN-LAST:event_btnTsaOKActionPerformed

	private void chkbTsaEnabledActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_chkbTsaEnabledActionPerformed
		switchTsaEnabled();
	}// GEN-LAST:event_chkbTsaEnabledActionPerformed

	private void formComponentShown(java.awt.event.ComponentEvent evt) {// GEN-FIRST:event_formComponentShown
		updateFromOptions();
		switchTsaEnabled();
	}// GEN-LAST:event_formComponentShown

	private void formComponentHidden(java.awt.event.ComponentEvent evt) {// GEN-FIRST:event_formComponentHidden
		storeToOptions();
	}// GEN-LAST:event_formComponentHidden

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton btnTsaOK;
	private javax.swing.JComboBox cbProxyType;
	private javax.swing.JCheckBox chkbCrlEnabled;
	private javax.swing.JCheckBox chkbOcspEnabled;
	private javax.swing.JCheckBox chkbTsaEnabled;
	private javax.swing.JLabel lblProxyHost;
	private javax.swing.JLabel lblProxyType;
	private javax.swing.JLabel lblTsaPwd;
	private javax.swing.JLabel lblTsaUrl;
	private javax.swing.JLabel lblTsaUser;
	private javax.swing.JPasswordField pfTsaPwd;
	private javax.swing.JPanel pnlProxy;
	private javax.swing.JSpinner spProxyPort;
	private javax.swing.JTextField tfProxyHost;
	private javax.swing.JTextField tfTsaUrl;
	private javax.swing.JTextField tfTsaUser;
	// End of variables declaration//GEN-END:variables

}