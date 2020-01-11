<xsl:stylesheet
        xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="xml"/>
<xsl:template match="/">
    <xsl:for-each select="//device">
        <name><xsl:apply-templates select="./name"/></name>
        <origin><xsl:apply-templates select="./origin"/></origin>
        <price><xsl:apply-templates select="./price"/></price>
        <type><xsl:apply-templates select="./type"/></type>
    </xsl:for-each>
</xsl:template>
</xsl:stylesheet>