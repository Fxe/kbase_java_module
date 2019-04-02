/*
A KBase module: filipeliu_java_module
This sample module contains one small method that filters contigs.
*/

module filipeliu_java_module {
    typedef structure {
        string report_name;
        string report_ref;
    } ReportResults;

    /*
        This example function accepts any number of parameters and returns results in a KBaseReport
    */
    funcdef run_filipeliu_java_module(mapping<string,UnspecifiedObject> params) returns (ReportResults output) authentication required;

};
