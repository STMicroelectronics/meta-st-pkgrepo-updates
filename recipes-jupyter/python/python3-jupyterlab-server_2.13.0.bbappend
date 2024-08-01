# Drop the original dependency on python3-jsonschema as the version
# provided in /openembedded-core/meta/recipes-devtools/python
# is to recent compared to Jupyter requirements
RDEPENDS:${PN}:remove = "python3-jsonschema"

# Add the specific version dependency
RDEPENDS:${PN} += "python3-jsonschema-4.17.3"
